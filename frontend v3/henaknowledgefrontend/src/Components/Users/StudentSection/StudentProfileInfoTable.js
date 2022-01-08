import React from "react";
import DateHandler from "../../Utility/DateHandler";
import StudentIcon from "../../../Assets/studentIcon";
import "./adjustments.css";
const StudentProfileInfoTable = (props) => {
  return (
    <div className="teacherstudentcards">
      <div class="card">
        <div class="img-avatar">
          <StudentIcon />
        </div>
        <div class="card-text">
          <div class="portada"></div>
          <div class="title-total">
            <div class="title">Student</div>
            <h2>
              {props.user.firstName} {props.user.lastName}
            </h2>
            <div class="desc">
              <div>
                <h3>
                  Date of birth:{" "}
                  <DateHandler obtainedTimestamp={props.user.dateOfBirth} />
                </h3>
                <h3>email: {props.user.email}</h3>
                <h3>specialization: {props.user.specialization}</h3>
                <br></br>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default StudentProfileInfoTable;
