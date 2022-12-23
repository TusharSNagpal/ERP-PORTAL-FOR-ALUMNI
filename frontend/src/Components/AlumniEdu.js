import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import React from 'react';
import {useState} from "react";
import AlumniOrg from "./AlumniOrg";
import green from "../images/green.jpg";
import logo from "../images/IIITBLogo1.jpg";

function AlumniEdu(props) {
    const [address, setAddress] = useState('');
    const [college, setCollege] = useState('');
    const [degree, setDegree] = useState('');
    const [joining_year, setJoiningYear] = useState();
    const [passing_year, setPassingYear] = useState();


    const handleChangeAddress = event => {
        //console.log(event.target.value);
        setTick(false);
        setAddress(event.target.value);
    }

    const handleChangeCollege = event => {
        //console.log(event.target.value);
        setTick(false);
        setCollege(event.target.value);
    }
    const handleChangeDegree = event => {
        //console.log(event.target.value);
        setTick(false);
        setDegree(event.target.value);
    }
    const handleChangeJoiningYear = event => {
        //console.log(event.target.value);
        setTick(false);
        setJoiningYear(event.target.value);
    }
    const handleChangePassingYear = event => {
        //console.log(event.target.value);
        setTick(false);
        setPassingYear(event.target.value);
    }

    const[showConfirmation,setConfirmation] = useState(false);
    const[error,setError] = useState(false);

    const signUp = async() => {
        console.log(props.alumni_id);
        let data = {'alumni':{'alumni_id' : props.alumni_id}, 'address' : address, 'college_name' : college, 'degree' : degree, 'joining_year' : joining_year, 'passing_year': passing_year};
        console.log(JSON.stringify(data));
        const addRecordEndpoint = "http://localhost:8080/restLab4-1.0-SNAPSHOT/api/alumni_edu/register";
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
            console.log("DONE");
            setError(false);
            setConfirmation(true);
            setTick(true);
        }

        else{
            console.log("ERROR");
            setTick(false);
            setConfirmation(false);
            setError(true);
        }
        setAddress("");
        setCollege("");
        setDegree("");
        setJoiningYear("");
        setPassingYear("");
    }

    const [alumniOrg, setAlumniOrg] = useState(false);

    const handleAluOrg = () => {
         setConfirmation(false);
         setError(false);
         setAlumniOrg(true);
    }

    const[tick,setTick] = useState(false);

    return (
        <div>
            {!alumniOrg ?
                <Form className="alu_edu">
                    <Form.Group className="mb-3" controlId="address">
                        <Form.Label> Address </Form.Label>
                        <Form.Control type="text" placeholder="Enter Address" onChange={handleChangeAddress}
                                      value={address}/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="college">
                        <Form.Label>College</Form.Label>
                        <Form.Control type="text" placeholder="Enter College Name" onChange={handleChangeCollege}
                                      value={college}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="degree">
                        <Form.Label>Degree</Form.Label>
                        <Form.Control type="text" placeholder="Enter Degree Name" onChange={handleChangeDegree}
                                      value={degree}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="joining_year">
                        <Form.Label>Joining Year</Form.Label>
                        <Form.Control type="text" placeholder="Enter Joining Year" onChange={handleChangeJoiningYear}
                                      value={joining_year}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="passing_year">
                        <Form.Label>Passing Year</Form.Label>
                        <Form.Control type="text" placeholder="Enter Passing Year" onChange={handleChangePassingYear}
                                      value={passing_year}/>
                    </Form.Group>

                    <Button className="mb-3" controlId="submit-button" variant="primary"
                            onClick={signUp}>
                        Submit
                    </Button> {tick ? <img src={green} className="green" alt="logo" /> :null}
                    <br/>
                </Form>
                :null}
            {!alumniOrg && showConfirmation ?
                <div>
                    <p className="text-muted, confirmation">
                        THANK YOU FOR BEING A PART OF IIITB FAM..! DATABASE SUCCESSFULLY UPDATED.. Please proceed and enter further organisation or Submit again for more education details. (past and present working details)!
                    </p>
                    <Button className="mb-3" controlId="submit-button" variant="primary"
                            onClick={async()=>{ await handleAluOrg();}}>
                        Proceed
                    </Button>
                </div>
                :null}
            {!alumniOrg && error ?
                <div>
                    <p className="text-muted, errorRed">
                        Either you are already registered or someone already entered similar value (PS: Database accepts unique values of Contact Number, Email) Please try again..!
                    </p>
                </div>
                :null}
            {alumniOrg ?
                <AlumniOrg alumni_id={props.alumni_id}></AlumniOrg>
                :null}
        </div>

    );
}

export default AlumniEdu;