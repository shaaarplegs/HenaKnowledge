import React from "react";
import Popup from "reactjs-popup";
import "reactjs-popup/dist/index.css";
import StudentIcon from "../../../Assets/studentIcon";
const StudentSearchingCard = (props) => {
  return (
      <div class="card">
        <div class="img-avatar">
          <StudentIcon />
        </div>
        <div class="card-text">
          <div class="portada"></div>
          <div class="title-total">
            <div class="title">Student</div>
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
                <Popup trigger={<button>remove</button>} modal nested>
                  <h1>
                    Are you certain you would like to remove {props.firstName}{" "}
                    {props.lastName}
                    from henaknowledge ?
                  </h1>
                  <button onClick={props.deleteFun}>remove</button>
                </Popup>
              )}

              {props.contact && (
                <Popup trigger={<button>contact</button>} modal nested>
                  <h1 className="movingtext">
                    Contact email info: {props.email}
                  </h1>
                  <p>
                    * The feature of contacting the teacher is still in
                    developing!
                  </p>
                </Popup>
              )}
            </div>
          </div>
        </div>
      </div>
  );
};

export default StudentSearchingCard;

/*


    <div>
      <h4>first name: {props.firstName}</h4>
      <h4>last name: {props.lastName}</h4>
      <h4>email name: {props.email}</h4>
      <br></br>
      {props.deleteStatus && (
        <Popup
          trigger={<button>remove student</button>}
          modal
          nested
        >
          <h1>
            Are you certain you would like to remove {props.firstName} {props.lastName}
            from henaknowledge ?
          </h1>
          <button onClick={props.deleteFun}>remove student</button>
        </Popup>
      )}
    </div>

*/
