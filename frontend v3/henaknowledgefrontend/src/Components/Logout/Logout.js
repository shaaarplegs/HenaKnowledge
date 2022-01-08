import React, {useEffect} from "react";
import { Redirect, Switch } from "react-router";
import { AuthActions } from "../../Store/AuthSlice";
import { useDispatch } from "react-redux";

const Logout = (props) => {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(AuthActions.logout());
  }, []);
  return (
    <Switch>
      <Redirect to="/" />
    </Switch>
  );
};

export default Logout;
