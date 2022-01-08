import React from "react";
import "./infocard.css";
import TeacherIcon from "../../../Assets/teacherIcon";

import Popup from "reactjs-popup";
import "reactjs-popup/dist/index.css";
import StudentContactInfo from "./StudentContactInfo";
const TeacherSearchingCard = (props) => {
  return (
    <div className="teacherstudentcards">
      <div class="card">
        <div class="img-avatar">
          <TeacherIcon />
        </div>
        <div class="card-text">
          <div class="portada"></div>
          <div class="title-total">
            <div class="title">Teacher</div>
            <h2>
              {props.firstName} {props.lastName}
            </h2>

            <div class="desc">
              <div>
                <h4>email name: {props.email}</h4>
                <h4>specialization : {props.specialization}</h4>
                <br></br>
              </div>
            </div>
            <div class="actions">
              {props.deleteStatus && (
                <Popup
                  trigger={<button onClick={props.deleteFun}>Remove</button>}
                  modal
                  nested
                >
                  <h1>
                    Are you certain you would like to remove the teacher{" "}
                    {props.firstName} {props.lastName} from henaknowledge ?
                  </h1>
                  <button onClick={props.deleteFun}>Remove teacher</button>
                </Popup>
              )}
              {props.contact && (
                <Popup trigger={<button>contact</button>} modal nested>
                  <StudentContactInfo teacherID={props.teacherID} />
                    Send your questions to
                    <h2>
                      {props.firstName} {props.lastName}
                    </h2>
                </Popup>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TeacherSearchingCard;
