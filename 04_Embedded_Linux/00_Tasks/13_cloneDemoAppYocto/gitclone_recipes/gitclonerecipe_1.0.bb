
SUMMARY = "Repo clone and build"
DESCRIPTION = "Fetches a repo using git, builds it with cmake, and installs the binary."
LICENSE = "MIT"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


inherit cmake
DEPENDS = "cmake"


S= "${WORKDIR}/git"
D= "${WORKDIR}/image"


SRC_URI = "git://github.com/FadyKhalil/DemoApp.git;protocol=https;branch=main"
SRCREV = "720c663c5fd7246b4b42c5205d74db7d9784b5b2"

do_configure() {
    
    mkdir -p ${B}   
    cd ${B}         
    cmake ${S} -DCMAKE_INSTALL_PREFIX=${D}    
}

do_compile() {
    oe_runmake -C ${B}
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/calculator ${D}${bindir}/
}

