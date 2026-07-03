import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import MyHeader from "./components/MyHeader";
import FoodList from "./components/FoodList";
import Cart from "./components/Cart";
import Order from "./components/Order";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Footer from "./components/Footer";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <MyHeader />
        <Routes>
          <Route path="/" element={<FoodList />}></Route>
          <Route path="/cart" element={<Cart />}></Route>
          <Route path="/order" element={<Order/>}></Route>
        </Routes>
        <Footer/>
      </BrowserRouter>
    </>
  );
};

export default App;
