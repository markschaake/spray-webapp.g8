console.info "we have coffee!"
window.myModule = angular.module "myModule", ["ngResource"]
window.myController = ($scope, $resource) ->
  ToDo = $resource('/api/todos/:id')
  Peep = $resource('/api/peeps/:id')

  $scope.todos = ToDo.query()
  $scope.peeps = Peep.query()
  $scope.addTodo = ->
    toAdd = new ToDo({text: $scope.todoText, done: false})
    toAdd.$save()
    $scope.todos.push toAdd
    $scope.todoText = null
