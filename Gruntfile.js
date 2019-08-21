module.exports = function(grunt) {

    grunt.initConfig({
      ts: {
        default: {
          src: ['src/main/resources/static/ts/*.ts'],
          dest: 'src/main/resources/static/js/compiled_ts',
          options: {
            module: 'system', // this might need to be amd
            moduleResolution: 'node', // allows jquery import to work
            target: 'es5',
            experimentalDecorators: true,
            emitDecoratorMetadata: true,
            noImplicitAny: false,
            sourceMap: false
          }
        }
      }
    });
  
    grunt.loadNpmTasks('grunt-ts');
    grunt.registerTask('default', ['ts']);
  };
