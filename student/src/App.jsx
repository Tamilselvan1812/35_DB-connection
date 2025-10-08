import React, { useState } from "react";
import axios from "axios";

function App() {
  const [students, setStudents] = useState([]);
  const [searchValue, setSearchValue] = useState("");

  
  const fetchAll = () => {
    axios.get("http://localhost:8080/students")                              // Fetch all students
      .then(res => setStudents(res.data))
      .catch(err => console.log(err));
  };

       
  const searchStudent = () => {                                             // Search student by ID or Name
    if (!searchValue) return;

    const isNumber = !isNaN(searchValue);
    if (isNumber) {
      
      axios.get(`http://localhost:8080/students/id/${searchValue}`)           // search by ID
        .then(res => setStudents(res.data ? [res.data] : []))
        .catch(err => console.log(err));
    } else {
     
      axios.get(`http://localhost:8080/students/name?name=${searchValue}`)     // search by Name
        .then(res => setStudents(res.data))
        .catch(err => console.log(err));
    }
  };

  return (
    <div>
      <h1>Student Details</h1>

      <button onClick={fetchAll}>Get All Students</button>

      <input
        type="text"
        placeholder="Enter name or ID"
        value={searchValue}
        onChange={(e) => setSearchValue(e.target.value)}
      />
      <button onClick={searchStudent}>Search</button>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Marks</th>
          </tr>
        </thead>
        <tbody>
          {students.map((s) => (
            <tr key={s.id}>
              <td>{s.id}</td>
              <td>{s.name}</td>
              <td>{s.age}</td>
              <td>{s.marks}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
