import { Button } from "@/components/ui/button";
import { useLocation, useNavigate } from "react-router-dom";
import "./Auth.css";
import ForgotPasswordForm from "./ForgotPasswordForm";
import SigninForm from "./SigninForm";
import SignupForm from "./SignupForm";

const Auth = () => {
  const navigate = useNavigate();
  const location = useLocation();

  return (
    <div className="h-screen relative authContainer">
      <div className="absolute top-0 right-0 left-0 bottom-0 bg-[#030712] bg-opacity-50">
        <div className="bgBlure absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 flex flex-col justify-center items-center h-[35rem] w-[30rem] rounded-md z-50 bg-black bg-opacity-50 shadow-2xl shadow-white px-10">
          <h1 className="text-6xl font-bold pb-9">Trek Trading</h1>
          {location.pathname == "/signup" ? (
            <section className="w-full">
              <SignupForm />

              <div className="flex items-center justify-center">
                <span>Already have account ?</span>
                <Button onClick={() => navigate("/signin")} variant="ghost">
                  Sign In
                </Button>
              </div>
            </section>
          ) : location.pathname == "/forgot-password" ? (
            <section className="w-full">
              <ForgotPasswordForm />

              <div className="flex items-center justify-center mt-2">
                <span>Back to log in ?</span>
                <Button onClick={() => navigate("/signin")} variant="ghost">
                  Sign In
                </Button>
              </div>
            </section>
          ) : (
            <section className="w-full">
              <SigninForm />

              <div className="flex items-center justify-center">
                <span>{"Don't have account ?"}</span>
                <Button onClick={() => navigate("/signup")} variant="ghost">
                  Sign Up
                </Button>
              </div>

              <div className="mt-10">
                <Button
                  className="w-full py-5"
                  onClick={() => navigate("/forgot-password")}
                  variant="outline"
                >
                  Forgot Password
                </Button>
              </div>
            </section>
          )}
        </div>
      </div>
    </div>
  );
};

export default Auth;
