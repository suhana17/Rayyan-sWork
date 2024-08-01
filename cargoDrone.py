import time
import board
import adafruit_hcsr04
from adafruit_motor import motor

weightKilo = int()

gravity = 9.81
required_thrust = weightKilo * gravity

movingForward = bool
movingBackward = bool
movingRight = bool
movingLeft = bool

total = int()

sensorRight = adafruit_hcsr04.HCSR04(trigger_pin=board.D2, echo_pin=board.D3)
sensorLeft = adafruit_hcsr04.HCSR04(trigger_pin=board.D4, echo_pin=board.D5)
sensorBottom = adafruit_hcsr04.HCSR04(trigger_pin=board.D7, echo_pin=board.D8)
sensorTop = adafruit_hcsr04.HCSR04(trigger_pin=board.D8, echo_pin=board.D9)

topRight = motor.DCMotor(board.M1)
topLeft = motor.DCMotor(board.M2)
bottomRight = motor.DCMotor(board.M3)
bottomLeft = motor.DCMotor(board.M4)

def hover():
    topRight.throttle = required_thrust
    topLeft.throttle = required_thrust
    bottomRight.throttle = required_thrust
    bottomLeft.throttle = required_thrust

def goUp():
    topRight.throttle = required_thrust * 2
    topLeft.throttle = required_thrust * 2
    bottomRight.throttle = required_thrust * 2
    bottomLeft.throttle = required_thrust * 2

def goDown():
    topRight.throttle = required_thrust / 2
    topLeft.throttle = required_thrust / 2
    bottomRight.throttle = required_thrust / 2
    bottomLeft.throttle = required_thrust / 2

def moveForward():
    movingForward = True
    movingBackward = False
    movingRight = False
    movingLeft = False

def moveBackward():
    movingForward = False
    movingBackward = True
    movingRight = False
    movingLeft = False

def moveRight():
    movingForward = False
    movingBackward = False
    movingRight = True
    movingLeft = False

def moveLeft():
    movingForward = False
    movingBackward = False
    movingRight = False
    movingLeft = True

while True:

    if sensorRight.distance < 10:
        if movingForward:
            pass
        if movingBackward:
            pass
    if sensorLeft.distance < 10:
        if movingForward:
            pass
        if movingBackward:
            pass
    if sensorBottom.distance < 10:
        goUp()
    if sensorTop.distance < 10:
        goDown()

    time.sleep(0.1)
