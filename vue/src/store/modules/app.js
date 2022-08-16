const state = {
  pageSetting: {
    show: false
  },
}

const mutations = {
  CLOSE_PAGESETTING: (state, data) => {
    state.pageSetting.show = data
  },
  OPEN_PAGESETTING: (state, data) => {
    state.pageSetting.show = data
  },
}

const actions = {
  closePageSetting({ commit }) {
    commit('CLOSE_PAGESETTING')
  },
  openPageSetting({ commit },data) {
    commit('OPEN_PAGESETTING',data)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
