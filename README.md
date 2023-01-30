# MoviesApp
App can show the popluar and latest movies.
# MovieApp
App that can shows all the latest and popular movies.

The Android project uses Kotlin Flow and Coroutines for managing asynchronous data streams and performing background operations, Jetpack Compose for building UI, MVVM Clean Code Architecture for separating UI logic from business logic, Navigation Component for managing navigation between screens, Material Component for following material design guidelines, Retrofit for making network requests, Coil for loading images, Hilt Dagger for dependency injection, Junit for writing unit tests, and Swipe Refresh for enabling pull-to-refresh in the app.

# Technologies 
JetPack Compose
Hilt Dagger (Dependency Injection)
Material Design
MVVM Clean Code Architecture
Coil
Swipe Refresh
Coroutines
Kotlin Flow
JUnit 

<img src="https://user-images.githubusercontent.com/49866308/215449843-1e486bc5-1098-4bbb-b785-eb1260a6bd38.png" width="350" height="680"><img src="https://user-images.githubusercontent.com/49866308/215449861-1fb81c59-98ec-4aa5-83c1-364f9a3cae13.png" width="350" height="680">

#Architecture
A well planned architecture is extremely important for an app to scale and all architectures have one common goal- to manage complexity of your app. This isn't something to be worried about in smaller apps however it may prove very useful when working on apps with longer development lifecycle and a bigger team.

#Why Clean Architecture?
Loose coupling between the code - The code can easily be modified without affecting any or a large part of the app's codebase thus easier to scale the application later on. Easier to test code. Separation of Concern - Different modules have specific responsibilities making it easier for modification and maintenance.

Android Clean Architecture in this app is a sample project that presents modern, approach to Android application development using Kotlin and latest tech-stack.

The goal of the this project is to demonstrate best practices, provide a set of guidelines, and present modern Android application architecture that is modular, scalable, maintainable and testable. This application may look simple, but it has all of these small details that will set the rock-solid foundation of the larger app suitable for bigger teams and long application lifecycle management.

#S.O.L.I.D Principles
#Single Responsibility: Each software component should have only one reason to change – one responsibility.

#Open-Closed: You should be able to extend the behavior of a component, without breaking its usage, or modifying its extensions.

#Liskov Substitution: If you have a class of one type, and any subclasses of that class, you should be able to represent the base class usage with the subclass, without breaking the app.

#Interface Segregation: It’s better to have many smaller interfaces than a large one, to prevent the class from implementing the methods that it doesn’t need.

#Dependency Inversion: Components should depend on abstractions rather than concrete implementations. Also higher level modules shouldn’t depend on lower level modules.

#Layers
Data
The data layer is responsible for selecting the proper data source for the domain layer. It contains the implementations of the repositories declared in the domain layer.

#Components of data layer include:

local: This is responsible for performing caching operations using Room.

-datasource: This is responsible to structure local data souce

-dao: The dao - data access objects used to interact with stored data

-entity: This used to represent objects in the database

-db: It defines the database configuration and serves as the app's main access point to the persisted data

remote: This is responsible for performing network operations eg. defining API endpoints using Retrofit.

-dto: Defines dto of ui model, also perform data transformation between domain, response and entity models.

-datasource: This is responsible to structure remote data souce from Api

-api service: It provides snetwork response from Api

repository: Responsible for exposing data to the domain layer.

#Domain
This is the core layer of the application. The domain layer is independent of any other layers thus ] domain business logic can be independent from other layers.This means that changes in other layers will have no effect on domain layer eg. screen UI (presentation layer) or changing database (data layer) will not result in any code change withing domain layer.

#Components of domain layer include:

#usecase: They enclose a single action, like getting data from a database or posting to a service. They use the repositories to resolve the action they are supposed to do. They usually override the operator invoke , so they can be called as a function.
model: It has plain kotlin data class which are accessible to presentation layer
repository: This is optional when we use use_case. However, it is helpful to data flow from domain layer to presentation layer
Presentation
This can have many features if the app is complex enough which contains components involved in showing information to the user. The main part of this layer are the views(activity, compose) and ViewModels.

#Tech Stacks
This project uses many of the popular libraries, plugins and tools of the android ecosystem.

#Compose

#Material - Build Jetpack Compose UIs with ready to use Material Design Components.
#Foundation - Write Jetpack Compose applications with ready to use building blocks and extend foundation to build your own design system pieces.
#UI - Fundamental components of compose UI needed to interact with the device, including layout, drawing, and input.
#Lifecycle-ViewModel - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
#Navigation - Navigation in compose 
Jetpack

#Android KTX - Provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
#AndroidX - Major improvement to the original Android Support Library, which is no longer maintained.
#Lifecycle - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
#ViewModel - Designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations
#Dagger Hilt - Dependency Injection library.

#Google-KSP - Kotlin Symbol Processing API

#Retrofit - Type-safe http client and supports coroutines out of the box.

#OkHttp-Logging-Interceptor - Logs HTTP request and response data.

#Coroutines - Library Support for coroutines.

#Flow - Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously.

#Material Design - Build awesome beautiful UIs.

Coroutines - Library Support for coroutines,provides runBlocking coroutine builder used in tests.

#Test

Mockk - A modern Mockk library for UnitTest.
Coroutine-Test - Provides testing utilities for effectively testing coroutines.
Flow Test - Testing flows using Turbine
