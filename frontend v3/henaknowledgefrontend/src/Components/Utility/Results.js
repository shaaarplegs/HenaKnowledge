import React, { useState, useEffect } from "react";
import {
  NotificationContainer,
  NotificationManager,
} from "react-notifications";
import "react-notifications/lib/notifications.css";


const Results = (props) => {
  let initialState = props.init;
  const [msg, setmsg] = useState(initialState);

  useEffect(() => {

    if (props.Results) {
      NotificationManager.success(props.successMsg, "Click me!", 5000, () => {});
      setmsg(props.successMsg);
    }
    if (!props.Results) {
      NotificationManager.error(props.errorMsg, "Click me!", 5000, () => {});
      setmsg(props.errorMsg);
    }
  }, [props.Results]);
  return (
    <div>
      <NotificationContainer />
    </div>
  );
};

export default Results;
