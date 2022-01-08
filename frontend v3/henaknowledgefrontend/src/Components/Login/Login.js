import axios from "axios";
import React, { useState, useEffect } from "react";
import LoginResults from "./LoginResults";
import { useDispatch, useSelector } from "react-redux";
import { AuthActions } from "../../Store/AuthSlice";
import { useHistory } from "react-router-dom";
import "./style.css";
import Logo from "../../Logo/Logo";
const Login = (props) => {
  const History = useHistory();
  const dispatch = useDispatch();
  const loginState = useSelector((state) => state.auth.isLoggedin);
  const remainingDuration = useSelector(
    (state) => state.auth.remainingDuration
  );
  const [isLogginClicked, SetisLogginClicked] = useState(false);
  const [authResults, SetauthResults] = useState(false);
  const [isLoading, SetisLoading] = useState(false);
  const [username, SetUsername] = useState("");
  const [password, SetPassword] = useState("");

  const OnUsernameChangeHandler = (e) => {
    SetUsername(e.target.value);
  };

  const OnPasswordChangeHandler = (e) => {
    SetPassword(e.target.value);
  };

  const SubmitHandler = (e) => {
    e.preventDefault();

    SetisLoading(true);

    if (loginState) {
    } else {
      axios
        .post("http://localhost:8080/authenticate", {
          username: username,
          password: password,
        })
        .then((repos) => {
          SetisLoading(false);
          SetauthResults(true);
          dispatch(AuthActions.login(repos.data));
          History.replace("/");
        })
        .catch((error) => {
          SetisLoading(false);
          SetisLogginClicked(true);
          SetauthResults(false);
        });
    }
  };

  return (
    <>
      <div class="session">
        <div class="left">
          <Logo />
        </div>

        <div>
          <form onSubmit={SubmitHandler} classNameName="log-in">
            <h2>
              <span>Henaknowledge</span>
            </h2>
            <h2>
              <span>platform</span>
            </h2>
            <p>
              Welcome to the platform where you can explore experiences with
              other active people!
            </p>

            <div class="floating-label">
              <input
                type="text"
                placeholder="Username"
                value={username}
                onChange={OnUsernameChangeHandler}
              />
              <div class="icon">
                <svg x="0px" y="0px" width="12px" height="13px">
                  <path
                    fill="#B1B7C4"
                    d="M8.9,7.2C9,6.9,9,6.7,9,6.5v-4C9,1.1,7.9,0,6.5,0h-1C4.1,0,3,1.1,3,2.5v4c0,0.2,0,0.4,0.1,0.7 C1.3,7.8,0,9.5,0,11.5V13h12v-1.5C12,9.5,10.7,7.8,8.9,7.2z M4,2.5C4,1.7,4.7,1,5.5,1h1C7.3,1,8,1.7,8,2.5v4c0,0.2,0,0.4-0.1,0.6 l0.1,0L7.9,7.3C7.6,7.8,7.1,8.2,6.5,8.2h-1c-0.6,0-1.1-0.4-1.4-0.9L4.1,7.1l0.1,0C4,6.9,4,6.7,4,6.5V2.5z M11,12H1v-0.5 c0-1.6,1-2.9,2.4-3.4c0.5,0.7,1.2,1.1,2.1,1.1h1c0.8,0,1.6-0.4,2.1-1.1C10,8.5,11,9.9,11,11.5V12z"
                  />
                </svg>
                <rect class="st0" width="100" height="100" />
              </div>
            </div>
            <div class="floating-label">
              <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={OnPasswordChangeHandler}
              />
              <div class="icon">
                <svg x="0px" y="0px" width="15px" height="5px">
                  <g>
                    <path
                      fill="#B1B7C4"
                      d="M6,2L6,2c0-1.1-1-2-2.1-2H2.1C1,0,0,0.9,0,2.1v0.8C0,4.1,1,5,2.1,5h1.7C5,5,6,4.1,6,2.9V3h5v1h1V3h1v2h1V3h1 V2H6z M5.1,2.9c0,0.7-0.6,1.2-1.3,1.2H2.1c-0.7,0-1.3-0.6-1.3-1.2V2.1c0-0.7,0.6-1.2,1.3-1.2h1.7c0.7,0,1.3,0.6,1.3,1.2V2.9z"
                    />
                  </g>
                </svg>
              </div>
            </div>
            <button className="LoginBtn" type="submit">
              login
            </button>

            {isLoading && <p>Sending request...</p>}
            {isLogginClicked && <LoginResults authResults={authResults} />}
          </form>
        </div>
      </div>
    </>
  );
};

export default Login;
