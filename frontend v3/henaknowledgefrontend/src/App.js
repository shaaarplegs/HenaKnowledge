import logo from "./logo.svg";
import "./App.css";
import { Redirect, Switch, Route } from "react-router";
import Welcome from "./Components/Welcome/Welcome";
import Logout from "./Components/Logout/Logout";
import Login from "./Components/Login/Login";
import NavigationBar from "./Components/NavigationBar/NavigationBar";
import { useSelector } from "react-redux";
import StudentProfile from "./Components/Users/StudentSection/StudentProfile";
import TeacherProfile from "./Components/Users/TeacherSection/TeacherProfile";
import AdminProfile from "./Components/Users/AdminSection/AdminProfile";
import StudentPoints from "./Components/Users/StudentSection/StudentPoints";
import TeacherPoints from "./Components/Users/TeacherSection/TeacherPoints";
import StudentSearchingTeachers from "./Components/Users/StudentSection/StudentSearchingTeachers";
import UpdateStudentProfile from "./Components/Users/StudentSection/UpdateStudentProfile";
import UpdateTeacherProfile from "./Components/Users/TeacherSection/UpdateTeacherProfile";
import AdminSignUpStudent from "./Components/Users/AdminSection/AdminSignUpStudent";
import AdminSignupTeacher from "./Components/Users/AdminSection/AdminSignupTeacher";
import AdminDeleteTeacher from "./Components/Users/AdminSection/AdminDeleteTeacher";
import AdminDeleteStudent from "./Components/Users/AdminSection/AdminDeleteStudent";
import CreateExperience from "./Components/Users/Experience/CreateExperience";
import Experience from "./Components/Users/Experience/Experience";
import Experiences from "./Components/Users/Experience/Experiences";
import StudentContactHistory from './Components/Users/StudentSection/StudentContactHistory';
import StudentContact from './Components/Users/StudentSection/StudentContact';
import TeacherHistoryQuestions from './Components/Users/TeacherSection/TeacherHistoryQuestions';
import TeacherContact from './Components/Users/TeacherSection/TeacherContact';
import AdminStatisticsStudent from './Components/Users/AdminSection/AdminStatisticsStudent';
import AdminStatisticsTeacher from './Components/Users/AdminSection/AdminStatisticsTeacher';
import AdminDashBoard from './Components/Users/AdminSection/AdminDashBoard';
import AdminExchange from './Components/Users/AdminSection/AdminExchange';


function App() {

  const isLoggedin = useSelector((state) => state.auth.isLoggedin);
  const userType = useSelector((state) => state.auth.userType);
  return (
    <div className="App">
      <NavigationBar />
      <Switch>
        <Route path="/" exact>
          <Redirect to="/Welcome" />
        </Route>

        <Route path="/Welcome" exact>
          <Welcome />
        </Route>

        {!isLoggedin && (
          <Route path="/Login">
            <Login />
          </Route>
        )}
        {isLoggedin && (
          <Route path="/Logout">
            <Logout />
          </Route>
        )}

        {isLoggedin && userType === "Student" && (
          <>
            <Route path="/Student/Profile" exact>
              <StudentProfile />
            </Route>
            <Route path="/Student/Points">
              <StudentPoints />
            </Route>
            <Route path="/Student/SearchingTeachers">
              <StudentSearchingTeachers />
            </Route>
            <Route path="/Student/ContactHistory">
              <StudentContactHistory />
            </Route>
            <Route path="/Student/contact/:contactID" forceRefresh>
              <StudentContact />
            </Route>
            <Route path="/Student/Profile/Update">
              <UpdateStudentProfile />
            </Route>
            <Route path="/Student/ShareExperience">
              <CreateExperience />
            </Route>
            <Route path="/Student/Experiences" exact>
              <Experiences />
            </Route>
            <Route path="/Student/Experiences/:ExperienceID" forceRefresh>
              <Experience />
            </Route>
          </>
        )}

        {isLoggedin && userType === "Teacher" && (
          <>
            <Route path="/Teacher/Profile" exact>
              <TeacherProfile />
            </Route>
            <Route path="/Teacher/Profile/Update">
              <UpdateTeacherProfile />
            </Route>
            <Route path="/Teacher/Points">
              <TeacherPoints />
            </Route>
            <Route path="/Teacher/ContactHistory">
              <TeacherHistoryQuestions />
            </Route>
            <Route path="/Teacher/contact/:contactID" forceRefresh>
              <TeacherContact />
            </Route>
            <Route path="/Teacher/ShareExperience">
              <CreateExperience />
            </Route>
            <Route path="/Teacher/Experiences" exact>
              <Experiences />
            </Route>
            <Route path="/Teacher/Experiences/:ExperienceID" forceRefresh>
              <Experience />
            </Route>
          </>
        )}
        {isLoggedin && userType === "Admin" && (
          <>
            <Route path="/Admin/Profile">
              <AdminProfile />
            </Route>
            <Route path="/Admin/SignUpStudent">
              <AdminSignUpStudent />
            </Route>
            <Route path="/Admin/SignUpTeacher">
              <AdminSignupTeacher />
            </Route>
            <Route path="/Admin/FireTeacher">
              <AdminDeleteTeacher />
            </Route>
            <Route path="/Admin/RemoveStudent">
              <AdminDeleteStudent />
            </Route>
            <Route path="/Admin/StudentStatistics">
              <AdminStatisticsStudent />
            </Route>
            <Route path="/Admin/TeacherStatistics">
              <AdminStatisticsTeacher />
            </Route>
            <Route path="/Admin/Settings">
              <AdminDashBoard />
            </Route>
            <Route path="/Admin/Exchange">
              <AdminExchange />
            </Route>
          </>
        )}
      </Switch>
    </div>
  );
}

export default App;
