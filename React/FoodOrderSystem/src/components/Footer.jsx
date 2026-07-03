import React from "react";
import { GeoAlt, Phone, Envelope } from "react-bootstrap-icons";
import { BsClock } from "react-icons/bs";
import { FaFacebookF, FaInstagram, FaTwitter, FaWhatsapp } from "react-icons/fa";
import "../components/footer.css";

const Footer = () => {
  return (
    <footer className="footer text-light pt-5">

      {/* FEATURES */}
      <div className="container mb-5">
        <div className="row text-center g-4">

          {[
            { icon: "🚀", title: "Fast Delivery", desc: "Lightning fast at your doorstep" },
            { icon: "🍽️", title: "Best Quality", desc: "Top quality food guaranteed" },
            { icon: "💰", title: "Best Offers", desc: "Daily deals & discounts" },
            { icon: "🕒", title: "24/7 Support", desc: "Always here for you" },
          ].map((f, i) => (
            <div key={i} className="col-md-3">
              <div className="feature-box p-3">
                <h2>{f.icon}</h2>
                <h6 className="fw-bold">{f.title}</h6>
                <small>{f.desc}</small>
              </div>
            </div>
          ))}

        </div>
      </div>

      <hr className="border-secondary" />

      {/* MAIN */}
      <div className="container">
        <div className="row g-4">

          {/* BRAND */}
          <div className="col-md-3">
            <h3 className="fw-bold text-warning">Foodie 🍔</h3>
            <p className="small text-light opacity-75">
              Delicious food at your fingertips. We deliver your favorite meals fast & fresh.
            </p>

            {/* SOCIAL */}
            <div className="d-flex gap-3 mt-3">
              <FaFacebookF className="social-icon" />
              <FaInstagram className="social-icon" />
              <FaTwitter className="social-icon" />
              <FaWhatsapp className="social-icon" />
            </div>
          </div>

          {/* LINKS */}
          <div className="col-md-3">
            <h5 className="fw-bold mb-3">Quick Links</h5>
            <p className="footer-link">Home</p>
            <p className="footer-link">Restaurants</p>
            <p className="footer-link">Orders</p>
            <p className="footer-link">Cart</p>
          </div>

          {/* SUPPORT */}
          <div className="col-md-3">
            <h5 className="fw-bold mb-3">Customer Service</h5>
            <p className="footer-link">Help Center</p>
            <p className="footer-link">FAQs</p>
            <p className="footer-link">Privacy Policy</p>
            <p className="footer-link">Terms</p>
          </div>

          {/* CONTACT */}
          <div className="col-md-3">
            <h5 className="fw-bold mb-3">Contact</h5>
            <p><GeoAlt /> Pune, India</p>
            <p><Phone /> +91 9876543210</p>
            <p><Envelope /> support@foodie.com</p>
            <p><BsClock /> 9 AM - 11 PM</p>
          </div>

        </div>
      </div>

      {/* BOTTOM */}
      <div className="text-center mt-4 pt-3 border-top border-secondary">
        <small className="fs-5 mb-2">© 2026 Foodie. All rights reserved.</small>
      </div>

    </footer>
  );
};

export default Footer;