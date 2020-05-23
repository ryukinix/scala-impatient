[![works badge](https://cdn.jsdelivr.net/gh/nikku/works-on-my-machine@v0.2.0/badge.svg)](https://github.com/nikku/works-on-my-machine)
[![Build Status](https://travis-ci.com/ryukinix/scala-impatient.svg?branch=master)](https://travis-ci.com/ryukinix/scala-impatient)

# Description

Exercises of the book: Scala For The Impatient Ed2 (2016).

# Run exercises via SBT

``` bash
sbt test
```

# [DEPRECATED] Running exercises as HACKER

Ensure `Scala` is installed, assumed v2.11.22. Enter in `hack` folder
and execute `./run.scala`, examples:

```bash
./run.scala ch01/ex02.scala # print source code + execute scala code
./run.scala ch01/ex01.txt   # pretty print txt to stdout
./run.scala ch01            # show all solutions for chapter 01
```

Optionally, you can use make commands as well:

```bash
make # run all chapters
make ch01 # run chapter 01
```
