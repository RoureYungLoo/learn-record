// packages/[pkg].paths.js
// export default {
//     paths() {
//       return [
//         { params: { pkg: 'index' }},
//         { params: { pkg: '接下来的规划' }},
//         { params: { pkg: '电子日记' }}
//       ]
//     }
//   }

import fs from 'fs'

export default {
  paths() {
    return fs
      .readdirSync('packages')
      .map((pkg) => {
        return { params: { pkg }}
      })
  }
}