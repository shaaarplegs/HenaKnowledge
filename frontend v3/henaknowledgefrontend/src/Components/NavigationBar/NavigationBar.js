import React, { useState, useEffect } from "react";
import { Link, NavLink } from "react-router-dom";
import { useSelector } from "react-redux";
// import "./style2.css";
import "./style.css";
function NavigationBar() {
  const isLoggedin = useSelector((state) => state.auth.isLoggedin);
  const userType = useSelector((state) => state.auth.userType);

  return (
    <div className="page">
      <nav>
        <ul className="menu-bar">
          <li>
            <a
              onClick={() => window.open("http://localhost:3050", "_blank")}
            >
              <span>Chat</span>
            </a>
          </li>
          {/* <ul className="menuItems"> */}
          {!isLoggedin && (
            <li>
              <NavLink to="/Login">
                <span>Login</span>
              </NavLink>
            </li>
          )}

          {isLoggedin && userType === "Student" && (
            <>
              <li>
                <NavLink to="/Student/Profile">
                  <span>Profile</span>
                </NavLink>
              </li>
              <li>
                <Link to="/Student/Profile/Update">
                  Update personal information
                </Link>
              </li>
              <li>
                <NavLink to="/Student/Points">Your points</NavLink>
              </li>
              <li>
                <NavLink to="/Student/SearchingTeachers">
                  Teachers contact
                </NavLink>
              </li>
              <li>
                <NavLink to="/Student/ContactHistory">Contact history</NavLink>
              </li>
              <li>
                <NavLink to="/Student/ShareExperience">
                  Share Experience
                </NavLink>
              </li>
              <li>
                <NavLink to="/Student/Experiences">Experiences</NavLink>
              </li>
            </>
          )}

          {isLoggedin && userType === "Teacher" && (
            <>
              <li>
                <NavLink to="/Teacher/Profile">Profile</NavLink>
              </li>
              <li>
                <NavLink to="/Teacher/Profile/Update">
                  Update personal information
                </NavLink>
              </li>
              <li>
                <NavLink to="/Teacher/Points">Your points</NavLink>
              </li>
              <li>
                <NavLink to="/Teacher/ContactHistory">Contact history</NavLink>
              </li>
              <li>
                <NavLink to="/Teacher/ShareExperience">
                  Share Experience
                </NavLink>
              </li>
              <li>
                <NavLink to="/Teacher/Experiences">Experiences</NavLink>
              </li>
            </>
          )}

          {isLoggedin && userType === "Admin" && (
            <>
              <li>
                <NavLink to="/Admin/Profile">Profile</NavLink>
              </li>
              <li>
                <NavLink to="/Admin/SignUpStudent">Sign up a student</NavLink>
              </li>
              <li>
                <NavLink to="/Admin/SignUpTeacher">Sign up a teacher</NavLink>
              </li>
              <li>
                <NavLink to="/Admin/FireTeacher">Remove a teacher</NavLink>
              </li>
              <li>
                <NavLink to="/Admin/RemoveStudent">Remove a student</NavLink>
              </li>
              <li>
                <NavLink to="/Admin/StudentStatistics">
                  Student Statistics
                </NavLink>
              </li>
              <li>
                <NavLink to="/Admin/TeacherStatistics">
                  Teacher Statistics
                </NavLink>
              </li>
              <li>
                <NavLink to="/Admin/Settings">Points Settings</NavLink>
              </li>
              <li>
                <NavLink to="/Admin/Exchange">Exchange</NavLink>
              </li>
            </>
          )}

          {isLoggedin && (
            <li>
              <NavLink to="/Logout">
                <span>Logout</span>
              </NavLink>
            </li>
          )}
        </ul>
      </nav>
    </div>
  );
}

export default NavigationBar;
