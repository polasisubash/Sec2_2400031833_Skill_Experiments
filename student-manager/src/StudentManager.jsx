import { useState, useEffect } from "react";
import "./StudentManager.css";

const StudentManager = () => {
  const [students, setStudents] = useState(() => {
    const saved = localStorage.getItem("students");
    return saved ? JSON.parse(saved) : [
      { id: "1", name: "Rahul", course: "CSE" },
      { id: "2", name: "Anjali", course: "ECE" },
      { id: "3", name: "Kiran", course: "IT" },
      { id: "4", name: "Sneha", course: "EEE" },
      { id: "5", name: "Arjun", course: "MECH" },
    ];
  });

  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: "",
  });

  const [editIndex, setEditIndex] = useState(null);
  const [search, setSearch] = useState("");

  // Save to localStorage
  useEffect(() => {
    localStorage.setItem("students", JSON.stringify(students));
  }, [students]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewStudent({ ...newStudent, [name]: value });
  };

  const addOrUpdateStudent = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) {
      alert("Fill all fields");
      return;
    }

    if (editIndex !== null) {
      const updated = [...students];
      updated[editIndex] = newStudent;
      setStudents(updated);
      setEditIndex(null);
    } else {
      setStudents([...students, newStudent]);
    }

    setNewStudent({ id: "", name: "", course: "" });
  };

  const deleteStudent = (id) => {
    setStudents(students.filter((s) => s.id !== id));
  };

  const editStudent = (index) => {
    setNewStudent(students[index]);
    setEditIndex(index);
  };

  const filteredStudents = students.filter((s) =>
    s.name.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="container">
      <h2>Student Manager</h2>

      <input
        placeholder="Search by name..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />

      <div className="form">
        <input name="id" placeholder="ID" value={newStudent.id} onChange={handleChange} />
        <input name="name" placeholder="Name" value={newStudent.name} onChange={handleChange} />
        <input name="course" placeholder="Course" value={newStudent.course} onChange={handleChange} />
        <button onClick={addOrUpdateStudent}>
          {editIndex !== null ? "Update" : "Add"}
        </button>
      </div>

      {filteredStudents.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {filteredStudents.map((s, index) => (
              <tr key={s.id}>
                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.course}</td>
                <td>
                  <button onClick={() => editStudent(index)}>Edit</button>
                  <button className="delete-btn" onClick={() => deleteStudent(s.id)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default StudentManager;