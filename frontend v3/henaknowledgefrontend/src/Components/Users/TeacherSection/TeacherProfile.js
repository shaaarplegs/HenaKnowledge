import axios from "axios";
import React, { useState, useEffect } from "react";
import TeacherProfileInfoTable from "./TeacherProfileInfoTable";

const TeacherProfile = (props) => {
  const [user, setuser] = useState({});
  const [isLoading, SetisLoading] = useState(false);
  useEffect(() => {
    SetisLoading(true);
    axios
      .get(
        `http://localhost:8080/Teacher/getTeacher?username=${localStorage.getItem(
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
      })
      .catch((error) => {
        SetisLoading(false);
        console.log(error.response);
      });
  }, []);

  return (
    <div>
      <TeacherProfileInfoTable user={user} />
      {isLoading && <p>Obtaining data...</p>}
    </div>
  );
};

export default TeacherProfile;
