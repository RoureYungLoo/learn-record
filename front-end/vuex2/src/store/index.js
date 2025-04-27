import Vue from "vue";
import Vuex from 'vuex';

Vue.use(Vuex)

const store = new Vuex.Store({
	state: {
		counter: 0
	},
	actions: {
		add1(context, p) {
			console.log("action add1");
			context.commit('ADD1', 1)
		},
		sub1(context, p) {
			console.log("action sub1");
			context.commit('SUB1', 1)
		},
		add1Odd(context, p) {

			console.log("action add1Odd");
			if (context.state.counter % 2 != 0) {

				context.commit('ADD1ODD', 1)
			}
		},
		addLazy(context, p) {
			console.log("action addLazy");
			setTimeout(() => {
				context.commit('ADDLAZY', 1)
			}, 100)
		},
	},
	mutations: {
		ADD1(_state, _delta) {
			console.log("mutation ADD1");
			_state.counter += _delta
		},
		SUB1(_state, _delta) {
			console.log("mutation SUB1");
			_state.counter -= _delta
		},
		ADD1ODD(_state, _delta) {
			console.log("mutation ADD1ODD");
			if (_state.counter % 2 != 0) {
				_state.counter += _delta
			}
		},
		ADDLAZY(_state, _delta) {
			console.log("mutation ADDLAZY");
			setTimeout(() => {
				_state.counter += _delta
			}, 100)
		},
	},
	getters: {
		getCounter(_state) {
			console.log("getCounter", _state.counter);
			return _state.counter
		}
	}
})

export default store