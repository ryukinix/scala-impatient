exbegin() {
    printf "===========BEGIN==OF==EXERCISE: $1 =====================\n\n"
}
exend () {
    printf "\n=============END==OF==EXERCISE==========================\n\n"
}

abs_path () {
    local bin="$(readlink -f $0)"
    local dir="$(dirname $bin)"
    printf "$dir/$1"
}

extxt() {
    local f=$(abs_path $1)
    exbegin $f
    cat $f
    exend
}

exscala() {
    local f=$(abs_path $1)
    exbegin $f
    cat $f

    echo "Result: "
    scala -nc $f
    exend $fxs
}
