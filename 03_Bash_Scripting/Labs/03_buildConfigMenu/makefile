# Compiler
CC = $(COMPILER)

# Directories
SRC_DIR = src
INC_DIR = include
BIN_DIR = bin
BUILD_DIR = build
STATIC_LIB_DIR = static_lib
DYNAMIC_LIB_DIR = dynamic_lib

# Target executable
TARGET = calculator

# Flags
CFLAGS = -I$(INC_DIR) -fPIC
LDFLAGS = -L$(STATIC_LIB_DIR) -lcalculator_static -Wl,-rpath=$(STATIC_LIB_DIR)

# Source files
SRCS = $(wildcard $(SRC_DIR)/*.c)

# Object files
OBJS = $(patsubst $(SRC_DIR)/%.c,$(BIN_DIR)/%.o,$(SRCS))

# Default target
all: $(BUILD_DIR)/$(TARGET)

# Linking the target executable
$(BUILD_DIR)/$(TARGET): $(OBJS) $(STATIC_LIB_DIR)/libcalculator_static.a | $(BUILD_DIR)
	sudo $(CC) -o $@ $(OBJS) $(LDFLAGS)

# Compiling individual source files into object files
$(BIN_DIR)/%.o: $(SRC_DIR)/%.c | $(BIN_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

# Create necessary directories if they don't exist
$(BIN_DIR) $(BUILD_DIR) $(STATIC_LIB_DIR) $(DYNAMIC_LIB_DIR):
	mkdir -p $@

# Static library target
$(STATIC_LIB_DIR)/libcalculator_static.a: $(OBJS) | $(STATIC_LIB_DIR)
	ar rcs $@ $(OBJS)

# Dynamic library target
$(DYNAMIC_LIB_DIR)/libcalculator.so: $(OBJS) | $(DYNAMIC_LIB_DIR)
	$(CC) -shared -o $@ $(OBJS)

# Phony targets
.PHONY: all clean static dynamic

# Build static library
static: COMPILER = $(CC)
static: $(STATIC_LIB_DIR)/libcalculator_static.a

# Build dynamic library
dynamic: COMPILER = $(CC)
dynamic: $(DYNAMIC_LIB_DIR)/libcalculator.so

# Clean up build artifacts
clean:
	rm -rf $(BUILD_DIR) $(BIN_DIR) $(STATIC_LIB_DIR) $(DYNAMIC_LIB_DIR)

