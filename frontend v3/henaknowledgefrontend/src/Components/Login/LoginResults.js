import React, { useState, useEffect } from "react";
import {
  NotificationContainer,
  NotificationManager,
} from "react-notifications";
import "react-notifications/lib/notifications.css";

const LoginResults = (props) => {
  let initialState = "Please enter your username and password";
  const [msg, setmsg] = useState(initialState);

  useEffect(() => {
    if (!props.authResults) {
      NotificationManager.error(
        "Wrong credentials",
        "Click me!",
        5000,
        () => {}
      );
      setmsg("Wrong username or password!");
    }
  }, [props.authResults]);
  return (
    <div>
      {msg}
      <NotificationContainer />
    </div>
  );
};

export default LoginResults;
