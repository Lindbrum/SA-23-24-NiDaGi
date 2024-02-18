import {
  Badge,
  Card,
  CardHeader,
  CardFooter,
  Button,
  Table,
  Container,
  Row,
  Input,
} from "reactstrap";
import { Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';


import Header from "components/Headers/Header.js";
import { useEffect, useState } from "react";
import axios from 'axios';

const Reservations = () => {
  const [attractions, setAttractions] = useState([]);
  const [modal, setModal] = useState(false);
  const [reservations, setReservations] = useState([]);
  const [attractionId, setAttractionId] = useState();
  const [review, setReview] = useState('');
  const [reviewModal, setReviewModal] = useState(false);
  const [rating, setRating] = useState();
  const reviewToggle = () => setReviewModal(!reviewModal);
  const [selectedStar, setSelectedStar] = useState(0);

  const handleStarClick = (star) => {
    setSelectedStar(star);
  };


  const [time, setTime] = useState([]);

  const toggle = () => setModal(!modal);
  const fetchTimeSlots = async (id) => {
    axios.get(`http://localhost:8080/api/reservations/${id}`).then(res => { setTime(res.data) });
  }
  console.log(review);

  const giveStars = async (id) => {
    axios.post(`http://localhost:8080/api/emotional-buttons/add/${id}`, {
      body: review,
      userId: "290120",
      rating
    }).then(() => reviewToggle());

  }

  const giveReview = async (id) => {
    axios.post(`http://localhost:8080/api/reviews/add/${id}`, {
      body: review,
      userId: "290120",
      rating
    }).then(() => reviewToggle());

  }
  const giveRating = async (num) => {
    setRating(num);
  }
  const bookTimeSlot = async (id, start) => {
    axios.put(`http://localhost:8080/api/reservations/${id}`, {
      userId: 290120,
      slotStart: start
    }).then((res) => {
      console.log(res);
      toggle();
    }).catch(err => console.log(err));
  }

  const [showReviewsModal, setShowReviewsModal] = useState(false)
  const [reviewList, setReviewList] = useState([])
  const fetchReviewsForAttraction = async (id) => {
    axios.get(`http://localhost:8080/api/reviews/attraction/${id}`).then(res => {
      setReviewList(res.data)
    }).catch(err => { })
  }

  useEffect(() => {
    axios.get("http://localhost:8080/api/reservations").then(res => { setAttractions(res.data) }).catch(err => console.log(err));
    axios.get("http://localhost:8080/api/reservations/history/290120").then(res => { setReservations(res.data) }).catch(err => console.log(err));
  }, []);

  return (
    <>
      <Header />
      <Modal isOpen={modal} toggle={toggle} >
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
              {time?.map((item, index) => {
                return <tr>
                  <td>{item.start}</td>
                  <td>{item.end}</td>
                  <td><Button color="success" onClick={() => {
                    bookTimeSlot(item.attractionId, item.start)
                  }}> Book
                  </Button></td>


                </tr>
              })}
            </tbody>
          </Table>

        </ModalBody>

      </Modal>
      <Modal isOpen={reviewModal} toggle={reviewToggle} style={{ maxWidth: '1000px' }}>
        <ModalHeader toggle={reviewToggle}>Give us a Review</ModalHeader>
        <ModalBody>
          <p>Tell us about your level of satisfaction</p>
          <Table className="align-items-center" responsive>

            <tbody>
              {/* Populate table rows with actual data */}
              <td><Button onClick={() => giveRating(5)} style={{ border: rating === 5 ? "2px solid red" : "none" }}><img
                alt="..."
                src={require("../../assets/fonts/happy.jpg")}
                style={{ width: '50px' }}
              />Excellent</Button></td>
              <td><Button onClick={() => giveRating(4)} style={{ border: rating === 4 ? "2px solid red" : "none" }}><img
                alt="..."
                src={require("../../assets/fonts/happyt.jpg")}
                style={{ width: '50px' }}
              />Good</Button></td>
              <td><Button onClick={() => giveRating(3)} style={{ border: rating === 3 ? "2px solid red" : "none" }}><img
                alt="..."
                src={require("../../assets/img/brand/medium.jpg")}
                style={{ width: '50px' }}
              />Medium</Button></td>
              <td><Button onClick={() => giveRating(2)} style={{ border: rating === 2 ? "2px solid red" : "none" }}><img
                alt="..."
                src={require("../../assets/img/brand/poor.jpg")}
                style={{ width: '50px' }}
              />Poor</Button></td>
              <td><Button onClick={() => giveRating(1)} style={{ border: rating === 1 ? "2px solid red" : "none" }}><img
                alt="..."
                src={require("../../assets/img/brand/vpoor.jpg")}
                style={{ width: '50px' }}
              />Very Poor</Button></td>

              <tr>
                <p> Give us rating: </p>
              </tr>
              <tr>
                <td><Button onClick={() => handleStarClick(5)} style={{ border: selectedStar === 5 ? "2px solid red" : "none" }}>5 <i class="fa fa-star" aria-hidden="true"></i>
                </Button></td>
                <td><Button onClick={() => handleStarClick(4)} style={{ border: selectedStar === 4 ? "2px solid red" : "none" }}>4 <i class="fa fa-star" aria-hidden="true"></i>
                </Button></td>
                <td><Button onClick={() => handleStarClick(3)} style={{ border: selectedStar === 3 ? "2px solid red" : "none" }}>3 <i class="fa fa-star" aria-hidden="true"></i>
                </Button></td>
                <td><Button onClick={() => handleStarClick(2)} style={{ border: selectedStar === 2 ? "2px solid red" : "none" }}>2 <i class="fa fa-star" aria-hidden="true"></i>
                </Button></td>
                <td><Button onClick={() => handleStarClick(1)} style={{ border: selectedStar === 1 ? "2px solid red" : "none" }}>1 <i class="fa fa-star" aria-hidden="true"></i>
                </Button></td>
              </tr>

              {/* ... Repeat for other stars */}



              <tr>
                <td colSpan="5">Write us a review:
                  <Input value={review} onChange={(e) => setReview(e.target.value)} />
                </td>
              </tr>
              <tr>
                <td colSpan="5">
                  <Button onClick={() => {
                    giveReview(attractionId)
                    giveStars(attractionId)
                    setReview('')
                    setRating('')
                    setSelectedStar('')

                  }}>Submit</Button>
                </td>
              </tr>

            </tbody>
          </Table>

        </ModalBody>

      </Modal>
      <Modal isOpen={showReviewsModal} toggle={setShowReviewsModal}>
        <ModalHeader toggle={() => setShowReviewsModal(prev => !prev)}>Reviews:</ModalHeader>
        <ModalBody>
          <Table className="align-items-center" responsive>
            <thead className="thead-light">
              <tr>
                <th scope="col">Rating</th>
                <th scope="col">Review</th>


              </tr>
            </thead>
            <tbody>
              {/* Populate table rows with actual data */}
              {reviewList?.map((item, index) => {
                return <tr key={index}>
                  <td>{item.rating} stars</td>
                  <td>{item.body}</td>
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
                    <th scope="col">Show Reviews</th>

                  </tr>
                </thead>
                <tbody>
                  {/* Populate table rows with actual data */}
                  {attractions?.map((item, index) => {

                    return <tr>
                      <td>{item.name}</td>
                      <td>{item.capacity}</td>
                      <td>{item.queueLength}</td>
                      <td>{item.queueMinutes}</td>

                      <td><Button color="success" onClick={() => {
                        toggle();
                        fetchTimeSlots(item.id);
                      }}> Book
                      </Button></td>
                      <td><Button color="success" onClick={() => {
                        fetchReviewsForAttraction(item.id)
                        setShowReviewsModal(true)
                      }}> Show Reviews
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
                    <th scope="col" >List of Attractions</th>
                    <th scope="col">Time</th>
                  </tr>
                </thead>
                <tbody>
                  {/* Populate table rows with actual data */}
                  {reservations?.map((item, index) => {
                    return <tr>
                      <td>{item.attractionName}</td>
                      <td>{item.slotStart}</td>





                    </tr>
                  })}
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
                    <th scope="col">Time</th>
                    <th scope="col">Review</th>

                  </tr>
                </thead>
                <tbody>
                  {/* Populate table rows with actual data */}
                  {reservations?.map((item, index) => {
                    return <tr>
                      <td>{item.attractionName}</td>
                      <td>{item.slotStart}</td>


                      <td><Button color="success" onClick={() => {
                        setAttractionId(item.attractionId);
                        reviewToggle();

                      }}> Give Review
                      </Button></td>


                    </tr>
                  })}
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
