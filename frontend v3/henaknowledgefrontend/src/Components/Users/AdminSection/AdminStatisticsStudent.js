import React, { useState, useEffect } from "react";
import axios from "axios";
import StudentStatisticsCard from './StudentStatisticsCard'

const AdminStatisticsStudent = props => {
    const [students, setStudents] = useState([]);
    const [isLoading, SetisLoading] = useState(false);


    useEffect(() => {
        SetisLoading(true);
        axios
          .get(`http://localhost:8080/Student`, {
            headers: {
              Authorization: `Bearer ${localStorage.getItem("jwt")}`,
            },
          })
          .then((res) => {
            SetisLoading(false);
            setStudents(() => {
              return res.data;
            });
            console.log(res.data);
          })
          .catch((error) => {
            SetisLoading(false);
            console.log(error.response);
          });
      }, []);


    return (
      <div className="admin">
              {isLoading && <p>Loading...</p>}

        {!isLoading &&
          students.map((student) => {
            return (
              <StudentStatisticsCard
              studentID={student.personID}
              />
            );
          })}
        </div>
    )
}

export default AdminStatisticsStudent
