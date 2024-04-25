import {applyMiddleware, createStore} from 'redux';
import thunk from 'redux-thunk';
import { rootReducer } from './reducers';

const Configure = () => {
  let store = createStore(rootReducer, applyMiddleware(thunk));
  return store;
};
export {Configure};