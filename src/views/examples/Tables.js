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
import Header from "components/Headers/Header.js";

const Reservations = () => {
  return (
    <>
      <Header />
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
