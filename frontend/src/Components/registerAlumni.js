import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import React from 'react';
import {useState} from "react";
import AlumniEdu from "./AlumniEdu";

function RegisterAlumni(props) {
    const [contact_number, setContact] = useState();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleChangeContact = event => {
        //console.log(event.target.value);
        setContact(event.target.value);
    }

    const handleChangeEmail = event => {
        //console.log(event.target.value);
        setEmail(event.target.value);
    }
    const handleChangePassword = event => {
        //console.log(event.target.value);
        setPassword(event.target.value);
    }

    const[showConfirmation,setConfirmation] = useState(false);
    const[error,setError] = useState(false);

    const signUp = async() => {
        let data = {'students':{'student_id' : props.student_id}, 'contact_number' : contact_number, 'email' : email, 'password' : password};
        console.log(JSON.stringify(data));
        const addRecordEndpoint = "http://localhost:8080/restLab4-1.0-SNAPSHOT/api/alumni/register";
         const options = {
             method: 'POST',
             headers:{
                 'Content-Type': 'application/json'
             },
             body: JSON.stringify(data)
         }

         const response = await fetch(addRecordEndpoint, options);
         const result = await response;
         console.log(response);
         if(result['status'] === 200){
             setError(false);
             console.log("DONE");
             setConfirmation(true);
         }

         else{
             console.log("ERROR");
             setConfirmation(false);
             setError(true);
         }

     }

     const [propertyVal, setPropertyVal] = useState();

     const [alumniEdu, setAlumniEdu] = useState(false);

    const handleAlumni = async() => {
        await fetch(`http://localhost:8080/restLab4-1.0-SNAPSHOT/api/alumni/get/${email}`)
                .then((response) => response.json())
                .then((json) => {
                    setPropertyVal(json.alumni_id);
                    console.log(json);
                    setConfirmation(false);
                    setError(false);
                    setAlumniEdu(true);
                })
    }

    return (
        <div>
            {!alumniEdu ?
                <Form className="main_form">
                    <Form.Group className="mb-3" controlId="contact_number">
                        <Form.Label>Contact Number</Form.Label>
                        <Form.Control type="number" placeholder="Enter Contact Number" onChange={handleChangeContact}
                                      value={contact_number}/>

                        <Form.Text className="text-muted">
                            Don't worry we won't spam..!
                        </Form.Text>

                    </Form.Group>

                    <Form.Group className="mb-3" controlId="email">
                        <Form.Label>Email</Form.Label>
                        <Form.Control type="email" placeholder="Enter First Name" onChange={handleChangeEmail}
                                      value={email}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="password">
                        <Form.Label>Password</Form.Label>
                        <Form.Control type="password" placeholder="Enter Password" onChange={handleChangePassword}
                                      value={password}/>
                    </Form.Group>

                    <Button className="mb-3" controlId="submit-button" variant="primary"
                            onClick={signUp}>
                        Submit
                    </Button>
                    <br/>
                </Form>
                :null}
            {!alumniEdu && showConfirmation ?
            <div>
                    <p className="text-muted, confirmation">
                        THANK YOU FOR BEING A PART OF IIITB FAM..! DATABASE SUCCESSFULLY UPDATED.. Please proceed and enter further education details!
                    </p>
                    <Button className="mb-3" controlId="submit-button" variant="primary"
                            onClick={()=>{handleAlumni();}}>
                        Proceed
                    </Button>
            </div>
                :null}
            {!alumniEdu && error ?
                <div>
                    <p className="text-muted, errorRed">
                        Either you are already registered or someone already entered similar value (PS: Database accepts unique values of Contact Number, Email) Please try again..!
                    </p>
                </div>
                :null}
            {alumniEdu ?
                <AlumniEdu alumni_id={propertyVal}></AlumniEdu>
                :null}
        </div>

    );
}

export default RegisterAlumni;