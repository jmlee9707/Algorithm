const express = require("express");
const fs = require("fs");
const app = express();
const PORT = 5678;

//1. 요청사항 1
app.get("/", (request, response) => {
  response.status(200).setHeader("Content-Type", "application/json");
  response.json({ message: "server check" });
});

//2. post_count 합계 응답

app.get("/sum", (request, response) => {
  fs.readFile("./data/input/user.json", "utf-8", (err, data) => {
    if (err) {
      return response
        .status(500)
        .setHeader("Content-Type", "application/json")
        .json({ error: "파일을 읽어올 수 없습니다." });
    }

    try {
      const users = JSON.parse(data);
      const totalPostCount = users.reduce(
        (sum, user) => sum + user.post_count,
        0
      );
      console.log(totalPostCount);
      // 결과 응답
      response
        .status(200)
        .setHeader("Content-Type", "application/json")
        .json({ sum: totalPostCount });
    } catch (err) {
      console.log(err);
      return response
        .status(500)
        .setHeader("Content-Type", "application/json")
        .json({ error: "파일을 읽어올 수 없습니다." });
    }
  });
});

app.listen(PORT, "0.0.0.0", () => {
  console.log("server is running : " + PORT);
});
