import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import React, {useEffect} from 'react';
import {useState} from "react";
import Dropdown from 'react-bootstrap/Dropdown';
import green from "../images/green.jpg";

function AlumniOrg(props) {
    const [joining_date, setJoiningDate] = useState('');
    const [leaving_date, setLeavingDate] = useState('');
    const [position, setPosition] = useState('');
    const [org_id, setOrgID] = useState();

    const handleChangeJoiningDate = event => {
        //console.log(event.target.value);
        setJoiningDate(event.target.value);
        setTick(false);
    }

    const handleChangeLeavingDate = event => {
        //console.log(event.target.value);
        setLeavingDate(event.target.value);
        setTick(false);
    }
    const handleChangePosition = event => {
        //console.log(event.target.value);
        setPosition(event.target.value);
        setTick(false);
    }
    const handleChangeOrgID = event => {
        //console.log(event.target.value);
        setOrgID(event.target.value);
        setTick(false);
    }

    const[showConfirmation,setConfirmation] = useState(false);
    const[error,setError] = useState(false);

    const [tick,setTick] = useState(false);

    const signUp = async() => {
        console.log(props.alumni_id);
        let data = {'alumni':{'alumni_id' : props.alumni_id}, 'organisation':{'org_id' : org_id}, 'joining_date' : joining_date, 'leaving_date' : leaving_date, 'position' : position};
        console.log(JSON.stringify(data));
        const addRecordEndpoint = "http://localhost:8080/restLab4-1.0-SNAPSHOT/api/alumni_org/register";
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
            setJoiningDate("");
            setLeavingDate("");
            setPosition("");
            setOrgID("");
        }

        else{
            console.log("ERROR");
            setConfirmation(false);
            setTick(false);
            setError(true);
        }

    }

    // const handleAluOrg = async() => {
    //     await fetch(`http://localhost:8080/restLab4-1.0-SNAPSHOT/api/alumni/get/${email}`)
    //         .then((response) => response.json())
    //         .then((json) => {
    //             setEmailByID(json);
    //             console.log(json);
    //             console.log(emailByID);
    //         })
    //         .then(() => {
    //             setConfirmation(false);
    //             setError(false);
    //             setAlumniOrg(true);
    //         })
    // }

    const [orgData, setOrgData] = useState([]);
    useEffect(() => {
        fetch(`http://localhost:8080/restLab4-1.0-SNAPSHOT/api/organisation/get_all`)
            .then((response) => response.json())
            .then((json) => {
                setOrgData(json);
                console.log(json);
                console.log(orgData);
            })
    },[]);

    const handleChange = (event) => {
        setOrgID(event.target.value);
    }

    return (
        <div>
                <Form className="alu_edu">
                    <Form.Group className="mb-3" controlId="joining_date">
                        <Form.Label> Joining Date </Form.Label>
                        <Form.Control type="datetime-local" placeholder="Enter Joining Date" onChange={handleChangeJoiningDate}
                                      value={joining_date}/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="leaving_date">
                        <Form.Label>Leaving Date</Form.Label>
                        <Form.Control type="datetime-local" placeholder="Enter Leaving Date" onChange={handleChangeLeavingDate}
                                      value={leaving_date}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="position">
                        <Form.Label>Position</Form.Label>
                        <Form.Control type="text" placeholder="Enter Position Name" onChange={handleChangePosition}
                                      value={position}/>
                    </Form.Group>

                    <select value = {org_id} onChange={handleChange}>
                        <option value = "">SELECT ORGANISATION</option>
                        {orgData.map(org =>
                                    <option value = {org.org_id} key = {org.org_id}>{org.name}</option>
                        )}
                    </select>

                    <Button className="mb-3" controlId="submit-button" variant="primary"
                            onClick={signUp}>
                        Submit
                    </Button> {tick ? <img src={green} className="green" alt="logo" /> :null}
                    <br/>
                </Form>
            {showConfirmation ?
                <div>
                    <p className="text-muted, confirmation">
                        THANK YOU FOR BEING A PART OF IIITB FAM..! DATABASE SUCCESSFULLY UPDATED.. If you want to update more organisation details submit new details again We appreciate your efforts towards the college. Thank You Have a nice day!
                    </p>
                </div>
                :null}
            {error ?
                <div>
                    <p className="text-muted, errorRed">
                        Either you are already registered or someone already entered similar value. Please try again..!
                    </p>
                </div>
                :null}
        </div>

    );
}

export default AlumniOrg;