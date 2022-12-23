import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import React from 'react';
import {useState} from "react";
import umlDiagram from "../images/uml.jpg";
import {Link, Route, Router, Routes} from "react-router-dom";

import {useNavigate} from "react-router-dom"
//import {RegisterAlumni} from "./registerAlumni.js";

// import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import RegisterAlumni from "./registerAlumni";

function Searching() {
    const [grad_year, setGYear] = useState();
    const [fname, setFname] = useState('');
    const [lname, setLname] = useState('');

    const handleChangeGYear = event => {
        //console.log(event.target.value);
        setGYear(event.target.value);
    }

    const handleChangeFName = event => {
        //console.log(event.target.value);
        setFname(event.target.value);
    }
    const handleChangeLName = event => {
        //console.log(event.target.value);
        setLname(event.target.value);
    }

    const [alumniData, setAlumniData] = useState([]);

    const get_alumni_details = async() => {
        await fetch(`http://localhost:8080/restLab4-1.0-SNAPSHOT/api/students/getGrad/${grad_year}/${fname}/${lname}`)
            .then((response) => response.json())
            .then((json) => {
                setAlumniData(json);
                if(json.length != 0){
                    setNoRecord(false);
                    setShow(true);
                    setSearch(false);
                }
                else{
                    setNoRecord(true);
                }
                console.log(json);
                console.log(alumniData);
            })
    }

    const [show, setShow] = useState(false);

    const [showSearch, setSearch] = useState(true);

    const [noRecord, setNoRecord] = useState(false);

    const [register, setRegister] = useState(false);

    const[propertyVal, setPropertyVal] = useState(1);

    function handleRegister(){
        setRegister(true);
        setShow(false);
        setNoRecord(false);
        setSearch(false);
    }

    const [uml, showUML] = useState(false);

    const toggleUML = () => {
        if(uml)
            showUML(false);
        else
            showUML(true);
    }

    return (
        <div>
            {showSearch ?
                <Form className="main_form">
                    <Form.Group className="mb-3" controlId="g_year">
                        <Form.Label>Graduation Year</Form.Label>
                        <Form.Control type="number" placeholder="Enter Graduation Year" onChange={handleChangeGYear}
                                      value={grad_year}/>

                        <Form.Text className="text-muted">
                            Thank you for being a part of IIITB Fam..!
                        </Form.Text>

                    </Form.Group>

                    <Form.Group className="mb-3" controlId="fname">
                        <Form.Label>First Name</Form.Label>
                        <Form.Control type="text" placeholder="Enter First Name" onChange={handleChangeFName}
                                      value={fname}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="lname">
                        <Form.Label>Last Name</Form.Label>
                        <Form.Control type="text" placeholder="Enter Last Name" onChange={handleChangeLName}
                                      value={lname}/>
                    </Form.Group>

                    <Button className="mb-3" controlId="search_button" variant="primary"
                            onClick={async () => {
                                await get_alumni_details()
                                .then(() => {
                                    setShow(true);
                                    //console.log(alumniData);
                                    // if (alumniData.length != 0) {
                                    //     setNoRecord(false);
                                    //     setShow(true);
                                    //     setSearch(false);
                                    // } else if (alumniData.length === 0) {
                                    //     setNoRecord(true);
                                    // }
                                })
                            }}>
                        Search
                    </Button>
                    <br/>
                    {
                        noRecord ?
                            <Form.Text className="text-muted">
                                Sorry no record found in IIITB's Database please try again..!
                            </Form.Text>
                            : null
                    }
                    {/*<Form.Group className="mb-3" controlId="formBasicCheckbox">*/}
                    {/*    <Form.Check type="checkbox" label="Check me out" />*/}
                    {/*</Form.Group>*/}

                </Form> : null}

            {show && alumniData.length != 0 ?
                <table className="alumniSearch">
                    <thead>
                    <tr>
                        <th>EMAIL</th>
                        <th>CGPA</th>
                        <th>FIRST NAME</th>
                        <th>LAST NAME</th>
                        <th>GRADUATION YEAR</th>
                        <th>ROLL NUMBER</th>
                        <th>REGISTER</th>
                    </tr>
                    </thead>
                    <tbody>
                    {alumniData.map(alumni =>
                        <tr>
                            <td>{alumni.email}</td>
                            <td>{alumni.cgpa}</td>
                            <td>{alumni.first_name}</td>
                            <td>{alumni.last_name}</td>
                            <td>{alumni.graduation_year}</td>
                            <td>{alumni.roll_number}</td>
                            <td><Button onClick={()=>{handleRegister(); setPropertyVal(alumni.student_id);}}>CLICK</Button></td>
                        </tr>
                    )}
                    </tbody>
                </table> : null}

            {register ?
                <RegisterAlumni student_id = {propertyVal}/>
                :null }

            <Button className="mb-3" controlId="search_button" variant="primary" onClick={toggleUML}>
                Click here to see/hide UML Diagram
            </Button>
            <br />
            {uml ?
                <img src = {umlDiagram}/>
            :null}
        </div>

    );
}

export default Searching;