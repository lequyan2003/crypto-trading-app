import { thunk } from "redux-thunk";
import authReducer from "./Auth/Reducer";

import { combineReducers, legacy_createStore, applyMiddleware } from "redux";
import coinReducer from "./Coin/Reducer";
import walletReducer from "./Wallet/Reducer";
import withdrawalReducer from "./Withdrawal/Reducer";
import orderReducer from "./Order/Reducer";
import assetReducer from "./Asset/Reducer";

const rootReducer=combineReducers({
    auth: authReducer,
    coin: coinReducer,
    wallet: walletReducer,
    withdrawal: withdrawalReducer,
    order: orderReducer,
    asset: assetReducer,
});

export const store=legacy_createStore(rootReducer, applyMiddleware(thunk));
