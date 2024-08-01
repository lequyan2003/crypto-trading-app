import { Route, Routes } from "react-router-dom";
import Activity from "./pages/Activity/Activity";
import Auth from "./pages/Auth/Auth";
import Home from "./pages/Home/Home";
import Navbar from "./pages/Navbar/Navbar";
import Notfound from "./pages/Notfound/Notfound";
import PaymentDetails from "./pages/Payment Details/PaymentDetails";
import Portfolio from "./pages/Portfolio/Portfolio";
import Profile from "./pages/Profile/Profile";
import SearchCoin from "./pages/Search Coin/SearchCoin";
import StockDetails from "./pages/Stock Details/StockDetails";
import Wallet from "./pages/Wallet/Wallet";
import Watchlist from "./pages/Watchlist/Watchlist";
import Withdrawal from "./pages/Withdrawal/Withdrawal";

function App() {
  return (
    <>
      <Auth />
      {false && (
        <div>
          <Navbar />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/portfolio" element={<Portfolio />} />
            <Route path="/activity" element={<Activity />} />
            <Route path="/wallet" element={<Wallet />} />
            <Route path="/withdrawal" element={<Withdrawal />} />
            <Route path="/payment-details" element={<PaymentDetails />} />
            <Route path="/market/:id" element={<StockDetails />} />
            <Route path="/watchlist" element={<Watchlist />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/search-coin" element={<SearchCoin />} />
            <Route path="*" element={<Notfound />} />
          </Routes>
        </div>
      )}
    </>
  );
}

export default App;
