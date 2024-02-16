import {
  Badge,
  Card,
  CardHeader,
  CardFooter,
  Button,
  Table,
  Container,
  Row,
} from "reactstrap";
import { Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

import Header from "components/Headers/Header.js";
import { useEffect, useState } from "react";
import axios from 'axios';

const Reservations = () => {
  const [attractions,setAttractions]=useState([]);
  const [modal, setModal] = useState(false);
  
  const [time, setTime] = useState([]);


  const toggle = () => setModal(!modal);
  const fetchTimeSlots = async(id)=>{
    axios.get(`http://localhost:8080/api/reservations/${id}`).then(res=>{setTime(res.data)});
  }

  const bookTimeSlot = async(id,start)=>{
    axios({
      method: "PUT",
      url:`http://localhost:8080/api/reservations/${id}`,
      body:{"userId": 290120,
      "slotStart": start}
    }).then((res)=>{
      console.log(res);
      toggle();
    }).catch(err=>console.log(err));
  }

  useEffect(() => {
    axios.get("http://localhost:8080/api/reservations").then(res=>{setAttractions(res.data)}).catch(err=>console.log(err));
  }, []); 
  return (
    <>
      <Header />
      <Modal isOpen={modal} toggle={toggle}>
        <ModalHeader toggle={toggle}>Let's Book</ModalHeader>
        <ModalBody>
        <Table className="align-items-center" responsive>
                <thead className="thead-light">
                  <tr>
                    <th scope="col">Start Time</th>
                    <th scope="col">End Time</th>
                    <th scope="col">Book</th>
                  </tr>
                </thead>
                <tbody>
                  {/* Populate table rows with actual data */}
                  {time?.map((item,index)=>{
                    return <tr>
                      <td>{item.start}</td>
                      <td>{item.end}</td>
                      <td><Button color="success" onClick={()=>{
                        bookTimeSlot(item.attractionId, item.start)
                      }}> Book
                        </Button></td>


                    </tr>
                  })}
                </tbody>
              </Table>
       
        </ModalBody>
        
      </Modal>
      <Container className="mt--7" fluid>
        {/* Make Reservation Table */}
        <Row>
          <div className="col">
            <Card className="shadow">
              <CardHeader className="border-0">
                <h3 className="mb-0">Make Reservation</h3>
              </CardHeader>
              <Table className="align-items-center" responsive>
                <thead className="thead-light">
                  <tr>
                    <th scope="col">Name of Attractions</th>
                    <th scope="col">Capacity</th>
                    <th scope="col">Current Queue Length</th>
                    <th scope="col">Wait Time</th>
                    <th scope="col">Booking</th>
                  </tr>
                </thead>
                <tbody>
                  {/* Populate table rows with actual data */}
                  {attractions?.map((item,index)=>{
                    return <tr>
                      <td>{item.name}</td>
                      <td>{item.capacity}</td>
                      <td>{item.queueLength}</td>
                      <td>{item.queueMinutes}</td>
                      <td><Button color="success" onClick={()=>{
                        toggle();
                        fetchTimeSlots(item.id);
                      }}> Book
                        </Button></td>


                    </tr>
                  })}
                </tbody>
              </Table>
            </Card>
          </div>
        </Row>

        {/* Active Booking Table */}
        <Row className="mt-5">
          <div className="col">
            <Card className="shadow">
              <CardHeader className="border-0">
                <h3 className="mb-0">Active Booking</h3>
              </CardHeader>
              <Table className="align-items-center" responsive>
                <thead className="thead-light">
                  <tr>
                    {/* Define columns for Active Booking */}
                  </tr>
                </thead>
                <tbody>
                  {/* Populate table rows with actual data */}
                </tbody>
              </Table>
            </Card>
          </div>
        </Row>

        {/* Past Booking Table */}
        <Row className="mt-5">
          <div className="col">
            <Card className="shadow">
              <CardHeader className="border-0">
                <h3 className="mb-0">Past Booking</h3>
              </CardHeader>
              <Table className="align-items-center" responsive>
                <thead className="thead-light">
                  <tr>
                    <th scope="col">List of Attractions</th>
                    <th scope="col">Review</th>
                  </tr>
                </thead>
                <tbody>
                  {/* Populate table rows with actual data */}
                </tbody>
              </Table>
            </Card>
          </div>
        </Row>
      </Container>
    </>
  );
};

export default Reservations;
