
FILESEXTRAPATHS := "${THISDIR}/${PN}"

PRINC := "${@int(PRINC) + 1}"


# need custom files:
# 1. /etc/network/interfaces
# 2. /etc/dnsmasq.conf
# 3. 
