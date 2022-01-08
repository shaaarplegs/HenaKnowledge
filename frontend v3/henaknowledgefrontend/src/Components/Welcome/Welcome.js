import React, { useState, useEffect } from "react";
import axios from "axios";
import { useSelector } from "react-redux";
import "./style.css";

const Welcome = (props) => {
  const loginState = useSelector((state) => state.auth.isLoggedin);

  const [user, setuser] = useState({});
  const [isLoading, SetisLoading] = useState(false);

  let Url;
  if (localStorage.getItem("userType") === "Teacher") {
    Url = `http://localhost:8080/Teacher/getTeacher?username=`;
  } else if (localStorage.getItem("userType") === "Student") {
    Url = `http://localhost:8080/Student/getStudent?username=`;
  } else if (localStorage.getItem("userType") === "Admin") {
    Url = `http://localhost:8080/Admin/getAdmin?username=`;
  }
  useEffect(() => {
    SetisLoading(true);
    axios
      .get(`${Url}${localStorage.getItem("username")}`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        SetisLoading(false);
        setuser(res.data);
        localStorage.setItem('firstName', res.data.firstName)
        localStorage.setItem('lastName', res.data.lastName)
        localStorage.setItem('email', res.data.email)
        localStorage.setItem('personID', res.data.personID)
      })
      .catch((error) => {
        SetisLoading(false);
        console.log(error.response);
      });
  }, []);

  return (
    <div className="movingtext">
      {isLoading && <p>obtaining data...</p>}
      Welcome {loginState ? user.firstName + " " + user.lastName : "user"}
    </div>
  );
};

export default Welcome;
