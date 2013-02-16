console.info "we have coffee!"
myModule = angular.module "myModule", ["ngResource"]
myController = ($scope, $resource) ->
  ToDo = $resource('/api/todos/:id')
  Peep = $resource('/api/peeps/:id')

  $scope.todos = ToDo.query()
  $scope.peeps = Peep.query()
  $scope.addTodo = ->
  $scope.todos.push {text: $scope.todoText, done: false}
  $scope.todoText = null
  $scope.myObjects = [{name: "baz"}, {name: "biggy"}]
  $scope.myObject = {name: "foo", value: "bar"}
  #Person = $resource("/api/person/:id")