import React, { useState, useEffect } from "react";
import axios from "axios";
import TeacherStatisticsCard from './TeacherStatisticsCard';
const AdminStatisticsTeacher = props => {
    const [teachers, setteachers] = useState([]);
    const [isLoading, SetisLoading] = useState(false);


    useEffect(() => {
        SetisLoading(true);
        axios
          .get(`http://localhost:8080/Teacher`, {
            headers: {
              Authorization: `Bearer ${localStorage.getItem("jwt")}`,
            },
          })
          .then((res) => {
            SetisLoading(false);
            setteachers(() => {
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
          teachers.map((teacher) => {
            console.log(teacher.personID)
            return (
             
              <TeacherStatisticsCard
              teacherID={teacher.personID}
              />
            );
          })}
        </div>
    )
}

export default AdminStatisticsTeacher
