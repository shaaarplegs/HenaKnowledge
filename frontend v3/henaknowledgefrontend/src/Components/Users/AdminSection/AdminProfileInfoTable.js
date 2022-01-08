import React from "react";
import DateHandler from "../../Utility/DateHandler";
import AdminIcon from '../../../Assets/adminIcon';


const AdminProfileInfoTable = (props) => {
  return (
    <div class="card">
      <div class="img-avatar">
        <AdminIcon />
      </div>
      <div class="card-text">
        <div class="portada"></div>
        <div class="title-total">
          <div class="title">Admin</div>
          <h2>
            {props.user.firstName} {props.user.lastName}
          </h2>
          <div class="desc">
            <div>
              <h3>
                Date of birth: <DateHandler obtainedTimestamp={props.user.dateOfBirth} />
              </h3>
              <h3>email: {props.user.email}</h3>
              <br></br>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AdminProfileInfoTable;

// <div>
//       <label>Admin Personal Information Page</label>
//       <h3>firstName: {props.user.firstName}</h3>
//       <h3>lastName: {props.user.lastName}</h3>
//       <h3>
//         Date: <DateHandler obtainedTimestamp={props.user.dateOfBirth} />
//       </h3>
//       <h3>email: {props.user.email}</h3>
//     </div>
