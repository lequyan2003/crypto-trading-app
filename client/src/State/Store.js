import { thunk } from "redux-thunk";
import authReducer from "./Auth/Reducer";

import { combineReducers, legacy_createStore, applyMiddleware } from "redux";
import coinReducer from "./Coin/Reducer";
import walletReducer from "./Wallet/Reducer";

const rootReducer=combineReducers({
    auth: authReducer,
    coin: coinReducer,
    wallet: walletReducer,
});

export const store=legacy_createStore(rootReducer, applyMiddleware(thunk));
