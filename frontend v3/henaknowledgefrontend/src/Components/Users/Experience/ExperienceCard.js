import React, {useEffect, useState} from "react";
import { NavLink, Link } from "react-router-dom";
import "./experiencecard.css";
import Experience from "./Experience";
import { useSelector } from "react-redux";
import axios from 'axios';


let urlteacher;
let urlstudent;
const ExperienceCard = (props) => {
  const isLoggedin = useSelector((state) => state.auth.isLoggedin);
  const userType = useSelector((state) => state.auth.userType);
  const [fullName, SetFullname] = useState('')
  urlstudent = `/Student/Experiences/${props.ExperienceID}`;
  urlteacher = `/Teacher/Experiences/${props.ExperienceID}`;

  useEffect(() => {
    axios
      .get(
        `http://localhost:8080/Person/getFullName?PersonID=${props.personID}`,
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("jwt")}`,
          },
        }
      ).then((res)=>{
        SetFullname(res.data)
      })
  }, []);


  return (
    <>
      <div>
        <div class="main-container">
          <div class="heading-container"> Written by {fullName} </div>
          <div class="cardExp-container">
            <div class="cardExp card-1">
              <div class="cardExp__icon">
              </div>
              <p class="cardExp__exit">
              </p>
              <h2 class="cardExp__title">{props.title}</h2>
              <p class="cardExp__apply">
                {isLoggedin && userType === "Student" && (
                  <NavLink to={urlstudent}>
                    Check it out 
                  </NavLink>
                )}
                {isLoggedin && userType === "Teacher" && (
                  <NavLink to={urlteacher}>
                    Check it out
                  </NavLink>
                )}
              </p>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default ExperienceCard;
