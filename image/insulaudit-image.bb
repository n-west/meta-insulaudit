# Image for insulaudit, based on Angstrom's systemd-image. 
# Include some extra networking tools and usb drivers and utilities.

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

PR = "r1"

# Add to known working systemd-image from meta-angstrom
require recipes-core/images/core-image-minimal-dev.bb
# eventually we'll change that a little bit

# We want some extras
IMAGE_INSTALL += "socat usb-modeswitch \
        ppp curl ntpdate \
		kernel-modules \
		python vim screen git python-re python-subprocess python-pyserial\
		cmgpy insulware "

export IMAGE_BASENAME = "insulaudit-image"
