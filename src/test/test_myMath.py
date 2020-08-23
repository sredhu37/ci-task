import pytest
from src.main.myMath import *


def test_add():
    assert 4 + 5 == add(4, 5)


def test_add_type_error():
    with pytest.raises(TypeError):
        add("Hello", 3)


def test_subtract():
    assert 4 - 5 == subtract(4, 5)


def test_subtract_type_error():
    with pytest.raises(TypeError):
        subtract("Hello", 3)


def test_multiply():
    assert 4 * 5 == multiply(4, 5)


def test_multiply_string_integer():
    assert "HelloHelloHello" == multiply("Hello", 3)


def test_multiply_type_error():
    with pytest.raises(TypeError):
        multiply("Hello", 3.0)


def test_divide():
    assert 4/5 == divide(4, 5)


def test_divide_type_error():
    with pytest.raises(TypeError):
        divide("Hello", 3)


def test_add_zero_division_error():
    with pytest.raises(ZeroDivisionError):
        divide(5, 0)
