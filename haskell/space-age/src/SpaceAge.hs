module SpaceAge (Planet(..), ageOn) where

data Planet = Mercury
            | Venus
            | Earth
            | Mars
            | Jupiter
            | Saturn
            | Uranus
            | Neptune

calcOnEarth :: Float -> Float -> Float
calcOnEarth seconds factor = seconds / 31557600 / factor

ageOn :: Planet -> Float -> Float
ageOn Mercury seconds = calcOnEarth seconds 0.2408467
ageOn Venus seconds = calcOnEarth seconds 0.61519726
ageOn Earth seconds = calcOnEarth seconds 1
ageOn Mars seconds = calcOnEarth seconds 1.8808158
ageOn Jupiter seconds = calcOnEarth seconds 11.862615
ageOn Saturn seconds = calcOnEarth seconds 29.447498
ageOn Uranus seconds = calcOnEarth seconds 84.016846
ageOn Neptune seconds = calcOnEarth seconds 164.79132
