import React, { useState, useEffect } from "react";
import axios from "axios";
const Comment = (props) => {
  const [Commentor, SetCommentor] = useState("");
  useEffect(() => {
    axios
      .get(
        `http://localhost:8080/Person/getFullName?PersonID=${props.personID}`,
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("jwt")}`,
          },
        }
      )
      .then((res) => {
        SetCommentor(res.data);
      });
  }, []);
  return (
    <div className="commentSection">
      <h4 >{Commentor} commented:</h4> 
      <div class="comment">
        <textarea readOnly>{props.commentBody}</textarea>
      </div>
    </div>
  );
};

export default Comment;
