import axios from "axios";
import React, { useState, useEffect } from "react";
import "./ContactCard.css";
import { NavLink } from "react-router-dom";

let contactURL;
const ContactCardTeacher = (props) => {
  const [firstname, setfirstname] = useState("");
  const [lastname, setlastname] = useState("");
  contactURL = `/Student/contact/${props.contactID}`;
  useEffect(() => {
    axios
      .get(`http://localhost:8080/Teacher/${props.teacherID}`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("jwt")}`,
        },
      })
      .then((res) => {
        console.log(res.data);
        setfirstname(res.data.firstName);
        setlastname(res.data.lastName);
      });
  }, []);


  return (
    <NavLink  to={contactURL}>
      <div class="contactCard">
          {firstname} {lastname}
        <div class="historyIcon">
          <i class="fa fa-history" aria-hidden="true"></i>
        </div>
      </div>
    </NavLink>
  );
};

export default ContactCardTeacher;
