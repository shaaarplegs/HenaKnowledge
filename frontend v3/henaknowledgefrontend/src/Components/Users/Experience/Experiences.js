import React,{useState, useEffect} from 'react'
import ExperienceCard from './ExperienceCard';
import axios from "axios";

const Experiences = props => {
    const [isLoading, SetisLoading] = useState(false);
    const [experiences, Setexperiences] = useState([])
    useEffect(() => {
        SetisLoading(true);
        axios
          .get(`http://localhost:8080/Experience`, {
            headers: {
              Authorization: `Bearer ${localStorage.getItem("jwt")}`,
            },
          })
          .then((res) => {
            SetisLoading(false);
            Setexperiences(res.data)
          })
          .catch((error) => {
            SetisLoading(false);
          });
      }, []);
    
    return (
        <div>
            {isLoading && <p>obtaining data...</p>}
            {experiences.length === 0 && <p> No experiences has been shared yet...</p>}
            {!isLoading && 
                <div> 
                    {
                     
                         experiences.map((experience) => {
                            return (
                              <ExperienceCard
                                key={experience.experienceID}
                                ExperienceID={experience.experienceID}
                                title={experience.title}
                                personID={experience.personID}
                              />
                            );
                          })
                    }
                </div>
            }
        </div>
    )
}

export default Experiences
