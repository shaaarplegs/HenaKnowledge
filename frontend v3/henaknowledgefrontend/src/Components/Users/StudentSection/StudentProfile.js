import axios from "axios";
import React, { useState, useEffect } from "react";
import { Switch, Route } from "react-router";
import StudentProfileInfoTable from "./StudentProfileInfoTable";
import UpdateStudentProfile from "./UpdateStudentProfile";

const StudentProfile = (props) => {
  const [user, setuser] = useState({});
  const [isLoading, SetisLoading] = useState(false);
  useEffect(() => {
    SetisLoading(true);
    axios
      .get(
        `http://localhost:8080/Student/getStudent?username=${localStorage.getItem(
          "username"
        )}`,
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("jwt")}`,
          },
        }
      )
      .then((res) => {
        SetisLoading(false);
        setuser(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        SetisLoading(false);
        console.log(error.response);
      });
  }, []);

  return (
    <div className="studentfixcard">
      <StudentProfileInfoTable user={user} />
      {isLoading && <p>Obtaining data...</p>}
    </div>
  );
};

export default StudentProfile;
