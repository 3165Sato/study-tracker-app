"use client";

import { useEffect, useState } from "react";

type StudyRecord = {
  id: number;
  title: string;
  studyTime: number;
  category: string;
};

export default function StudyTrackerPage() {
  const [records, setRecords] = useState<StudyRecord[]>([]);
  const [title, setTitle] = useState("");
  const [studyTime, setStudyTime] = useState("");
  const [category, setCategory] = useState("");

  useEffect(() => {
    const loadRecords = async () => {
      try {
        const response = await fetch("http://localhost:18080/api/records");
        const data = await response.json();
        setRecords(data);
      } catch (error) {
        console.error("データ取得エラー：", error);
      }
    };
    loadRecords();
  }, []);

  const fetchRecords = async () => {
    try {
      const response = await fetch("http://localhost:18080/api/records");
      const data = await response.json();
      setRecords(data);
    } catch (error) {
      console.error("データ取得エラー：", error);
    }
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    await fetch("http://localhost:18080/api/records", {
      method: "POST",
      headers: {
        "content-Type": "application/json",
      },
      body: JSON.stringify({
        title,
        studyTime: Number(studyTime),
        category,
      }),
    });

    setTitle("");
    setStudyTime("");
    setCategory("");

    await fetchRecords();
  };

  return (
    <div>
      <h1>学習記録一覧</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <input
            type="text"
            placeholder="タイトル"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
        </div>
        <div>
          <input
            type="number"
            placeholder="学習時間"
            value={studyTime}
            onChange={(e) => setStudyTime(e.target.value)}
          />
        </div>
        <div>
          <input
            type="text"
            placeholder="カテゴリー"
            value={category}
            onChange={(e) => setCategory(e.target.value)}
          />
        </div>
        <button type="submit">登録</button>
      </form>
      <ul>
        {records.map((record) => (
          <li key={record.id}>
            {record.title} / {record.studyTime}分 / {record.category}
          </li>
        ))}
      </ul>
    </div>
  );
}
